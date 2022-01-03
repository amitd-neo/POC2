package io.h2o.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "project")
public class Project {
    @Id
    @SequenceGenerator(name = "project_sequence", sequenceName = "project_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_sequence")
    @Column(name = "project_id", nullable = false)
    private Long id;

    @Column(name = "project_name", nullable = false)
    private String name;

    @Column(name = "project_duration", nullable = false)
    private String duration;


    @JsonBackReference
    @ManyToOne()
    @JoinColumn(name="student_id")
    private Student student;
}
