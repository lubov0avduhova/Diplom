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
@Table(name = "price")
public class Price {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;
    @NotNull
    private int cost;

    @OneToOne(mappedBy = "price", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private Gifts gifts;

    public Price(int cost) {
        this.cost = cost;
    }
}
