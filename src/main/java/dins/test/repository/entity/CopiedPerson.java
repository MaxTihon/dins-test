package dins.test.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "copied_person")
public class CopiedPerson {
    @Id
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private Date timestamp;
}
