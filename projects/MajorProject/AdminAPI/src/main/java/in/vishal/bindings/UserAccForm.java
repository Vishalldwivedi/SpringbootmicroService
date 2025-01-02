package in.vishal.bindings;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

//Data will crete all the boiler plate codes , getter setter, toStrong constructors
//but for binding class we dont use ToString method as it set stack over flow ever
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserAccForm {
    private String fullName;
    private String email;
    private Long mobileNo;
    private String gender;
    private LocalDate dob;
    private Long ssn;
    private String activeSw;
    private Integer roleId;
}
