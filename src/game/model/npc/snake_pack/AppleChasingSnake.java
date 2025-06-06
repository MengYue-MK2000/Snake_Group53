package game.model.npc.snake_pack;
import game.model.npc.apple_pack.Apple;
import java.util.List;

// Class representing enemy snake
public class AppleChasingSnake extends EnemySnake{

    // Initialize the snake with length and starting position
    public AppleChasingSnake(int initialLength, int startX, int startY) {
        super(initialLength, startX, startY);
    }

    // Basic snake movement
    @Override
    public void move(List<Apple> apples, Head playerHead) {
        //perform default movement if there aren't any apples
        if (apples.isEmpty()){
            super.move(apples, playerHead);
            return;
        }

        //finds closest apple
        Apple closestApple = apples.get(0);
        int[]head = this.getHeadPosition();
        int closeDis = Math.abs(closestApple.getPosition()[0] - head[0]) +
                Math.abs(closestApple.getPosition()[1] - head[1]);
        for (Apple apple : apples) {
            int[]applePos = apple.getPosition();
            int distance = Math.abs(applePos[0] - head[0]) + Math.abs(applePos[1] - head[1]);
            if (distance < closeDis) {
                closeDis = distance;
                closestApple = apple;
            }
        }

        //finds direction of closest apple
        int directionX = Integer.compare(head[0], closestApple.getPosition()[0]);
        int directionY = Integer.compare(head[1], closestApple.getPosition()[1]);
        super.move(directionX, directionY);
    }
}
