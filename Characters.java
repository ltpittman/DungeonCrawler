class Characters{
	
	private String name;
	private int health;
	private int weaponStrength;
	private int armorStrength;
	private Item equippedWeapon;
	private Item equippedArmor;
	public int x;
	public int y;

	//constuctor with basic character qualities
	protected Character (String name, int health){
		this.name = name;
		this.health = health'
	}
	
	String getName(){
		return this.name;
	}
	int getHealth(){
		return this.health;
	}
	public void setHealth(int num){
		this.health = num;
	}
	Item getEquippedArmor(){
		return inventory.getEquippedArmor;
	}
	Item get EquippedWeapon(){
		return inventory.getEquippedWeapon;
	}
	int getArmorStrength(){
		armorStrength = equippedArmor.getStrength();
		return armorStrength;
	}
	int getWeaponStrength(){
		weaponStrength = equippedWeapon.getStrength();
		return weaponStrength;
	}
	public int getPostionX(){
		return this.x;
	}
	public int getPositionY(){
		return this.y;
	}
	public void getLocation(){
		System.out.println("Location: " + getPostionX() + "," + getPositionY());
	}


