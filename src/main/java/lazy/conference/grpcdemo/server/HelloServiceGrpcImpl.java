package lazy.conference.grpcdemo.server;

import io.grpc.stub.StreamObserver;
import lazy.conference.grpcdemo.proto.HelloRequest;
import lazy.conference.grpcdemo.proto.HelloResponse;
import lazy.conference.grpcdemo.proto.HelloServiceGrpc;

public class HelloServiceGrpcImpl extends HelloServiceGrpc.HelloServiceImplBase {
    @Override
    public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        HelloResponse reply = HelloResponse.newBuilder().setMessage("Hello " + request.getMessage()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
