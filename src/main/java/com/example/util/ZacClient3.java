//package com.example.util;
//
//import java.net.URI;
//
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.UriBuilder;
//
//import org.apache.catalina.WebResource;
//import org.glassfish.jersey.client.ClientConfig;
//import org.glassfish.jersey.client.ClientResponse;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
///**
// * @Author: zac
// */
//
//public class ZacClient3 {
//    private static final Logger log = LoggerFactory.getLogger(ZacClient3.class);
//
//    // http://apistore.baidu.com/
//    // http://developer.yahoo.co.jp/appendix/
//    // https://map.yahooapis.jp/placeinfo/V1/get
//    public static void main(String[] args) {
//        ClientConfig cc = new ClientConfig();
////        if(StringUtils.isNotEmpty(proxyHost) && StringUtils.isNotEmpty(proxyPort)) {
////            System.setProperty("http.proxyHost", proxyHost);  
////            System.setProperty("http.proxyPort", proxyPort); 
////        }
//        Client client = Client.create(cc);
//        WebResource service = client.resource(getBaseURI());
//        // Fluent interfaces
//        System.out.println("1:" + service.path("rest").path("hello").accept(MediaType.TEXT_PLAIN).get(ClientResponse.class).toString());
//        // Get plain text
//        System.out.println("2:" + service.path("rest").path("hello").accept(MediaType.TEXT_PLAIN).get(String.class));
//        // Get XML
//        System.out.println("3:" + service.path("rest").path("hello").accept(MediaType.TEXT_XML).get(String.class));
//        // The HTML
//        System.out.println("4:" + service.path("rest").path("hello").accept(MediaType.TEXT_HTML).get(String.class));
//
////        System.out.println("5:" + service.path("rest").path("hello").accept(MediaType.TEXT_PLAIN_TYPE).post(String.class));
////        System.out.println("6:" + service.path("rest").path("hello").post(String.class, "9999999"));
////        System.out.println("7:" + service.path("rest").path("hello").path("first").post(String.class, "9999999"));
//
//        String param = "test";
//        // 传递单个参数param变量作为动态路径并且作为参数
////        System.out.println("8:" + service.path("rest").path("hello").path(param).post(String.class));
//
//        // 多个参数包含在路径中传递到方法中作为参数使用 ,123,456作为参数
////        System.out.println("9:" + service.path("rest").path("hello").path("123").path("456").post(String.class));
//
//    }
//
//    private static URI getBaseURI() {
//        return UriBuilder.fromUri("http://api.flickr.com/services/feeds/photos_public.gne?tags=cat&tagmode=any&format=json&jsoncallback=?").build();
//    }
//}