package pres.atbabie.boot3.ssm.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetail {
    private Long id;
    private String name;
    private String email;
    private Date birthday;


}
