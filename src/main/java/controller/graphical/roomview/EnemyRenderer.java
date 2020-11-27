package controller.graphical.roomview;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.characters.Character;
import model.characters.enemies.*;

/**
 * Renders the enemy according to their type by using
 * the visitor design pattern.
 *
 * Acts as the visitor.
 */
public class EnemyRenderer {

    private Image leaderBanditImage = loadImage("images/enemies/enemy.png");
    private Image trainedBanditImage = loadImage("images/enemies/enemy.png");
    private Image weakBanditImage = loadImage("images/enemies/enemy.png");

    /**
     * The container which the image of the monster will be shown in.
     */
    private ImageView enemyContainer;

    public EnemyRenderer(ImageView enemyContainer) {
        this.enemyContainer = enemyContainer;
        clearContainer();
    }

    /**
     * The method applying the visitor pattern by calling the 'accept' method
     * of the enemy.
     * If the room has no enemy to render or if the enemy is dead, it clears the
     * container and returned. Otherwise, it visits the enemy.
     *
     * @param enemy - The enemy to render.
     */
    public void render(Character enemy) {
        checkEnemy(enemy);
        if (enemy.isDead()) {
            clearContainer();
            return;
        }
        ((Enemy) enemy).accept(this);
        show();
    }

    /**
     * Throws an IlegalArgumentException if the specified character is not
     * an enemy.
     * @param enemy - The character to check.
     */
    private void checkEnemy(Character enemy) {
        if (!(enemy instanceof Enemy)) throw new IllegalArgumentException(
                    "Illegal type in render : expected \"Enemy\"" + " but was \""+enemy.getClass()+"\""
            );
    }

    /**
     * Makes the container visible.
     */
    private void show() {
        enemyContainer.setVisible(true);
    }

    /**
     * Makes the container invisible.
     */
    public void clearContainer() {
        enemyContainer.setVisible(false);
    }

    /**
     * Returns the image corresponding to the
     * file at the given path.
     * @param path - the path to the image file.
     *
     * @return the image corresponding to the filepath.
     */
    private Image loadImage(String path) {
        return new Image(path);
    }

    public void renderEnemy(LeaderBandit enemy) {
        enemyContainer.setImage(leaderBanditImage);
    }

    public void renderEnemy(TrainedBandit enemy) {
        enemyContainer.setImage(trainedBanditImage);
    }

    public void renderEnemy(WeakBandit enemy) {
        enemyContainer.setImage(weakBanditImage);
    }

    public void renderEnemy(PersonalizedEnemy enemy) {
        enemyContainer.setImage(leaderBanditImage);
    }



}
