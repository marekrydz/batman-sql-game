package hello;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Greeting {

    //private final long id;
    private  String content;

    public Greeting(){

    }
    public Greeting(String content) {
//        this.id = id;
        this.content = content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    //    public long getId() {
//        return id;
//    }


    public String getContent() {
        return content;
    }
}
