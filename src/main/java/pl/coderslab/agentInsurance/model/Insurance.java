package pl.coderslab.agentInsurance.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "insurances")
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    @NotEmpty
    private String provider;
    @NotEmpty
    private String insuranceNumber;
    @NotEmpty
    private String insuranceValidDate;

    @ManyToOne
    private Client client;
    @ManyToOne
    private Vehicle vehicle;

}