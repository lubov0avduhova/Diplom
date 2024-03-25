package diplom.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import static jakarta.persistence.GenerationType.IDENTITY;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "gifts")
public class Gifts {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    @Column(columnDefinition = "short_name")
    @NotNull
    private String shortName;

    @NotNull
    private String description;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "price")
    @JsonIgnore
    private Price price;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "picture")
    @JsonIgnore
    private Picture picture;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usersSex")
    @JsonIgnore
    private UsersSex usersSex;

}
