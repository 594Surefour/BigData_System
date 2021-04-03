package service.demo;

import org.apache.thrift.TException;

import service.demo.Hello.Iface;

/**
 * 实现服务端提供的服务（实现Iface接口的代码）
 * 
 * @author chenyouhuang
 * 
 */
public class HelloServiceImpl implements Iface {

    @Override
    public String helloString(String para) throws TException {
        return para;
    }

    @Override
    public int helloInt(int para) throws TException {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return para + 1;
    }

    @Override
    public boolean helloBoolean(boolean para) throws TException {
        return para;
    }

    @Override
    public void helloVoid() throws TException {
        System.out.println("Hello World!");
    }

    @Override
    public String helloNull() throws TException {
        return null;
    }

}
