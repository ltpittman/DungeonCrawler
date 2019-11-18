import java.util.ArrayList;
import java.util.Random;

class MonsterGenerator{
	static Enemy generateMonster(){
		
		ArrayList<Enemy> enemyList;
		enemyList = new ArrayList<Enemy>();
		
		//Adding monsters to list. --> Name, health, damage, y, x, type.
		Enemy ghoul = new Enemy("Ghoul", 100, 24, 4, 3, MonsterType.Ghoul);
		enemyList.add(ghoul);

		Enemy vampire = new Enemy("Vampire", 100, 28, 9, 8, MonsterType.Vampire);
		enemyList.add(vampire);

		Enemy werewolf = new Enemy("Werewolf", 100, 32, 2, 10, MonsterType.Werewolf);
		enemyList.add(werewolf);

		Enemy zombie = new Enemy("Zombie", 100, 21, 7, 16, MonsterType.Zombie);
		enemyList.add(zombie);

		Enemy ghost = new Enemy("Ghost", 100, 26, 10, 12, MonsterType.Ghost);
		enemyList.add(ghost);

		//Pick a random monster from the arrayList.
		Random random_Monster = new Random();
		return enemyList.get(random_Monster.nextInt(enemyList.size()));

	}
}

