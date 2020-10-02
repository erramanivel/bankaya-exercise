package com.bayanka.examen.repositories.domains;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "origin_ip")
    private String originIp;

    @Column(name = "request_method")
    private String requestMethod;

    @Column(name = "request_date")
    private Date requestDate;
}
