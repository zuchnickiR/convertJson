package classes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Utility {


    public class JsonUtility {


        //mapowanie na Stringa z obiektu
        public static String toJsonString(Object ob) {
            String jsonToString = "";
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                jsonToString = objectMapper.writeValueAsString(ob);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            return jsonToString;
        }


        public static <I> I toObject(String jsonString, Class<I> cls) {
            I result = null;
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                result = objectMapper.readValue(jsonString, cls);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            return result;    }

        public JsonUtility() {
        }


    }
}
