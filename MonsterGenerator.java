import java.util.ArrayList;
import java.util.Random;

class MonsterGenerator{
	static Enemy generateMonster(){
		
		ArrayList<Enemy> enemyList;
		enemyList = new ArrayList<Enemy>();
		
		//Adding monsters to list. --> Name, health, and damage, y, and x coordinates.
		Enemy ghoul = new Enemy(MonsterType.Ghoul, "Ghoul", 100, 20, 14, 3);
		enemyList.add(ghoul);

		Enemy vampire = new Enemy(MonsterType.Vampire, "Vampire", 100, 22, 10, 8);
		enemyList.add(vampire);

		Enemy werewolf = new Enemy(MonsterType.Werewolf, "Werewolf", 100, 24, 22, 10);
		enemyList.add(werewolf);

		Enemy zombie = new Enemy(MonsterType.Zombie, "Zombie", 100, 23, 12, 16);
		enemyList.add(zombie);

		Enemy ghost = new Enemy(MonsterType.Ghost, "Ghost", 100, 25, 15, 12);
		enemyList.add(ghost);

		//Pick a random monster from the arrayList.
		Random random_Monster = new Random();
		return enemyList.get(random_Monster.nextInt(enemyList.size()));

	}
}

