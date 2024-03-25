package diplom.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users_sex")
public class UsersSex {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;
    @NotNull
    private boolean sex;
    @NotNull
    private String description;

    @OneToOne(mappedBy = "usersSex", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private Gifts gifts;
}
