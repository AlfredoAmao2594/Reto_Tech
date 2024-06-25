package com.reto.tech.springboot.app.Bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Requestkpideclientes {

	private Double promedio;
	private Double desviacion;
}
