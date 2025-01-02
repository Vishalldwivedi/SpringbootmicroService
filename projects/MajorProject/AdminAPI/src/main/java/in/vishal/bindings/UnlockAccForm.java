package in.vishal.bindings;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UnlockAccForm {
    private String email;
    private String tempPwd;
    private String newPwd;
    private String confirmPwd;
}
