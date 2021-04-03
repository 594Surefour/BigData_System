package service.client;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import service.demo.Hello;

/**
 * 客户端
 * 调用 Hello.client 访问服务端的逻辑实现
 * 
 * @author chenyouhuang
 * 
 */
public class HelloClient {

    /**
     * 调用Hello服务
     */
    public void startClient() {

        try {

            // 设置调用的服务地址为本地，端口为1234
            TTransport transport = new TSocket("172.19.11.186", 1234);
            transport.open();

            // 数据传输协议有：二进制协议、压缩协议、JSON格式协议
            // 这里使用的是二进制协议
            // 协议要和服务端一致
            TProtocol protocol = new TBinaryProtocol(transport);
            Hello.Client client = new Hello.Client(protocol);

            // 调用服务器端的服务helloInt方法
            System.out.println(client.helloInt(12));

            // 关闭
            transport.close();
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        HelloClient client = new HelloClient();
        client.startClient("LONG LI ZHANG");
    }
}
