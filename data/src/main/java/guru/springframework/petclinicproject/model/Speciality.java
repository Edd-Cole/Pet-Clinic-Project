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
@Table(name = "specialities")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Speciality extends BaseEntity {
  
  @Column(name = "description")
  private String description;
  
}
