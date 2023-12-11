package lazy.conference.grpcdemo.client;

import io.grpc.Channel;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;
import lazy.conference.grpcdemo.proto.HelloRequest;
import lazy.conference.grpcdemo.proto.HelloResponse;
import lazy.conference.grpcdemo.proto.HelloServiceGrpc;
import lazy.conference.grpcdemo.proto.HelloServiceGrpc.HelloServiceBlockingStub;

public class HelloServiceClient {

    private final HelloServiceBlockingStub helloServiceBlockingStub;

    public HelloServiceClient(Channel channel) {
        this.helloServiceBlockingStub = HelloServiceGrpc.newBlockingStub(channel);
    }

    public void hello(String message) {
        try {
            HelloResponse response = helloServiceBlockingStub.hello(
                    HelloRequest.newBuilder()
                            .setMessage(message)
                            .build()
            );

            System.out.println(response.getMessage());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        String target = "localhost:50051";

        ManagedChannel channel = Grpc.newChannelBuilder(target, InsecureChannelCredentials.create())
                .build();

        var client = new HelloServiceClient(channel);

        client.hello("wold");
    }
}
