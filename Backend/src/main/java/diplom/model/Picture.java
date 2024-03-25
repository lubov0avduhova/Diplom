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
@Table(name = "picture")
public class Picture {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    @NotNull
    private byte[] url;

    @OneToOne(mappedBy = "picture", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private Gifts gifts;

    public Picture(byte[] url) {
        this.url = url;
    }
}
