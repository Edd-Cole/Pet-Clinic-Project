package guru.springframework.petclinicproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "type")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class PetType extends BaseEntity {
  
  @Column(name = "name")
  private String name;
  
}
