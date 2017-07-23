/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopoo.Model;

/**
 *
 * @author tiago
 */
public interface HitBox {
    public boolean isColiding(HitBoxCircle h);
    public boolean isColiding(HitBoxSquare h);

    public boolean isColiding(HitBox hitBox);
}
