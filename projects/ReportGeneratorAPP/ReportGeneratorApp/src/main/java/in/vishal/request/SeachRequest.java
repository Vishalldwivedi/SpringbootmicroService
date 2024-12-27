package in.vishal.request;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalTime;
@Data
public class SeachRequest {
    ///the data which is coming fromthe UI to represnt that data in object i need this
    //
    private String planName;
    private String planStatus;
    private String gender ;
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private LocalTime startDate;
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private LocalTime endDate;
    //that for data u collect will be stored in the search object
}
