package io.alevin.grpc;

import io.alevin.grpc.gen.HelloRequest;
import io.alevin.grpc.gen.HelloResponse;
import io.alevin.grpc.gen.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
          .usePlaintext()
          .build();

        HelloServiceGrpc.HelloServiceBlockingStub stub 
          = HelloServiceGrpc.newBlockingStub(channel);

        HelloResponse helloResponse = stub.hello(HelloRequest.newBuilder()
          .setFirstName("Google")
          .setLastName("gRPC")
          .build());
        
        System.out.println(helloResponse.getGreeting());

        channel.shutdown();
    }
}
