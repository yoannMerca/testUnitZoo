package com.testJunit.zoo;



public enum RaceEnum {
	LION (1,"Lion"),
	LOUP (2,"Loup"),
	POISSON(3,"Poisson"),
	BISON(4,"Bison"),
	AUTRE(5,"non reseigné");
	
	private String race;
	private int id;
	private RaceEnum(int id, String race) {
		this.race = race;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race= race;
	}

	/**
	 * 
	 * @param id
	 * @return par defaut Autre sinon ca cherche l'enum en fonction de son id
	 */
	public static RaceEnum getEnumRace(int id){
		RaceEnum cat = RaceEnum.AUTRE;
		 for(RaceEnum enu : values()){
			 if( enu.id == id){
				 cat = enu;
			 }
		 }
		 return cat;
	}
		
}
