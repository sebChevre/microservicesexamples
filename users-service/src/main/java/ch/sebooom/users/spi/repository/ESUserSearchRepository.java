package ch.sebooom.users.spi.repository;

import ch.sebooom.users.domain.model.User;
import ch.sebooom.users.domain.repository.UserSearchRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

@Component
public class ESUserSearchRepository implements UserSearchRepository{

    @Autowired
    private RestClient restClient;



    public void save () {


    }

    @Override
    public void save(User newUser)  {


        // instance a json mapper
        ObjectMapper mapper = new ObjectMapper(); // create once, reuse
        byte[] json = null;
// generate json
        try {
            json = mapper.writeValueAsBytes(newUser);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        HttpEntity entity = new NStringEntity(new String(json), ContentType.APPLICATION_JSON);

        //restClient.performRequest("PUT", "/posts/doc/1",entity);
        Map<String, String> params = Collections.singletonMap("pretty", "true");
        Header[] headers = {
        };
        try {
            restClient.performRequest("PUT", "/people/user/"+newUser.getId(), params, entity,headers);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
