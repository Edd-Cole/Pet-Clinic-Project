package guru.springframework.petclinicproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "pet")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pet extends BaseEntity {
  
  @Column(name = "name")
  private String name;
  @ManyToOne
  @JoinColumn(name = "type_id")
  private PetType petType;
  @ManyToOne
  @JoinColumn(name = "owner_id")
  private Owner owner;
  @Column(name = "birth_date")
  private LocalDate birthDate;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
  private Set<Visit> visits = new HashSet<>();
  
}
