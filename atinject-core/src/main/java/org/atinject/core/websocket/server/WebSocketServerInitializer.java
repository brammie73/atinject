package org.atinject.core.websocket.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpChunkAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.atinject.core.websocket.WebSocketEndpoint;

@ApplicationScoped
@WebSocketEndpoint(path="/websocket")
public class WebSocketServerInitializer {
    
    @Inject @WebSocketEndpoint(path="/websocket")
    private WebSocketServerHandler webSocketServerHandler;
    
    private ChannelInitializer<SocketChannel> initializer;
    
    @PostConstruct
    public void initialize(){
        initializer = new ChannelInitializer<SocketChannel>(){
            @Override
            public void initChannel(SocketChannel ch) throws Exception
            {
                ChannelPipeline pipeline = ch.pipeline();
                pipeline.addLast("decoder", new HttpRequestDecoder());
                pipeline.addLast("aggregator", new HttpChunkAggregator(65536));
                pipeline.addLast("encoder", new HttpResponseEncoder());
                pipeline.addLast("handler", webSocketServerHandler.get());
            }
        };
    }
    
    public ChannelInitializer<SocketChannel> getInitializer(){
        return initializer;
    }
}