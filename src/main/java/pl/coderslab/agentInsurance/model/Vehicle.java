package pl.coderslab.agentInsurance.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String category;
    @NotEmpty
    private String plateNumber;
    private String type;
    @NotEmpty
    private String color;
    @NotEmpty
    private String firstRegistrationDate;
    @ManyToOne
    private Client client;
    @ManyToOne
    private VehicleModel vehicleModel;
    @ManyToOne
    private Brand brand;
}
