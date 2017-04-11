package com.CheckOut;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringCloudApplication
@EnableMongoRepositories("com.CheckOut.repository")
public class CheckOutApplication {

	public static void main(String[] args) {
		SpringApplication.run(CheckOutApplication.class, args);
	}

//   @Component
//    public class SimpleCORSFilter implements ContainerResponseFilter {
//        @Override
//        public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
//            MultivaluedMap<String, Object> headers = responseContext.getHeaders();
//            headers.add("Access-Control-Allow-Origin", "*");
//            headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
//            headers.add("Access-Control-Allow-Headers", "*");
//        }
//    }
}
