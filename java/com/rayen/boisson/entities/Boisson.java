package com.rayen.boisson.entities;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;


	@Entity
	public class Boisson {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long idBoisson;
		@NotNull
		@Size (min = 4,max = 15)
	    private String nomBoisson;
		@Min(value = 10)
		 @Max(value = 10000)
	    private Double prixBoisson;
	    @Temporal(TemporalType.DATE)
	    @DateTimeFormat(pattern = "yyyy-MM-dd")
	    @PastOrPresent
	    private Date dateServir;
	    @ManyToOne
	     private Type type;

	    public Boisson() {
	        super();
	    }


		public Date getDateServir() {
			return dateServir;
		}



		public void setDateServir(Date dateServir) {
			this.dateServir = dateServir;
		}


		public Long getIdBoisson() {
			return idBoisson;
		}


		public void setIdBoisson(Long idBoisson) {
			this.idBoisson = idBoisson;
		}


		public String getNomBoisson() {
			return nomBoisson;
		}


		public void setNomBoisson(String nomBoisson) {
			this.nomBoisson = nomBoisson;
		}


		public Double getPrixBoisson() {
			return prixBoisson;
		}


		public void setPrixBoisson(Double prixBoisson) {
			this.prixBoisson = prixBoisson;
		}


		public Type getType() {
			return type;
		}


		public void setType(Type type) {
			this.type = type;
		}


		@Override
		public String toString() {
			return "Boisson [idBoisson=" + idBoisson + ", nomBoisson=" + nomBoisson + ", prixBoisson=" + prixBoisson
					+ ", dateServir=" + dateServir + "]";
		}


		public Boisson( String nomBoisson, Double prixBoisson, Date dateServir) {
			super();
			
			this.nomBoisson = nomBoisson;
			this.prixBoisson = prixBoisson;
			this.dateServir = dateServir;
		}


		

	    
	}
