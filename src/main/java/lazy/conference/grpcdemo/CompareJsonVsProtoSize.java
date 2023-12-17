package lazy.conference.grpcdemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lazy.conference.grpcdemo.proto.Member;

public class CompareJsonVsProtoSize {
    public static void main(String[] args) throws JsonProcessingException {
        Member member = Member.newBuilder()
                .setName("choi sangyong")
                .setBirthday("1994-12-18")
                .setEmail("169developer@gmail.com")
                .build();

        JsonMember jsonMember = new JsonMember("choi sangyong", "1994-12-18", "169developer@gmail.com");
        ObjectMapper objectMapper = new ObjectMapper();

        System.out.println("Protocol Buffer Size : " + member.toByteArray().length);
        System.out.println("Json Size : " + objectMapper.writeValueAsBytes(jsonMember).length);
    }

    public static class JsonMember {

        private final String name;
        private final String birthday;
        private final String email;

        public JsonMember(String name, String birthday, String email) {
            this.name = name;
            this.birthday = birthday;
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public String getBirthday() {
            return birthday;
        }

        public String getEmail() {
            return email;
        }
    }
}
