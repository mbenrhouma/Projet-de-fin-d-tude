package com.cynapsys.pojo;


public class DetailCession {
	
	private Integer cession ;
	private Long sommeMontantrecu ;
	
	
	
	
	
	
	public DetailCession(Integer cession, Long sommeMontantrecu) {
		this.cession = cession;
		this.sommeMontantrecu = sommeMontantrecu;
	}
	
	public Integer getCession() {
		return cession;
	}
	public void setCession(Integer cession) {
		this.cession = cession;
	}
	public Long getSommeMontantrecu() {
		return sommeMontantrecu;
	}
	public void setSommeMontantrecu(Long sommeMontantrecu) {
		this.sommeMontantrecu = sommeMontantrecu;
	}


	
	
	
	
	

}
