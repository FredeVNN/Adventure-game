public class AttackOutcome {

    // Stores attack results and attacked enemy:
    private final AttackResult playerAttackResult;
    private final AttackResult enemyAttackResult;
    private final Enemy enemy;

    // Constructor:
    public AttackOutcome(AttackResult playerAttackResult, AttackResult enemyAttackResult, Enemy enemy) {
        this.playerAttackResult = playerAttackResult;
        this.enemyAttackResult = enemyAttackResult;
        this.enemy = enemy;
    }

    // Gets player attack result:
    public AttackResult getPlayerAttackResult() {
        return playerAttackResult;
    }

    // Gets enemy attack result:
    public AttackResult getEnemyAttackResult() {
        return enemyAttackResult;
    }

    // Gets attacked enemy:
    public Enemy getEnemy() {
        return enemy;
    }
}
