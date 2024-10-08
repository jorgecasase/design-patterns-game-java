package com.game.enemy.enemyfactory;

import com.game.player.player.Player;

public interface Enemy {
    public String getNombre();
    public Integer getVida();
    public Integer getFuerza();
    public Integer getAgilidad();
    public Integer getResistencia();
    public Integer getCuracion();
    public void recibirAtaque(Integer danio);
    public void setVida(Integer vida);
    public void setEsquivar(boolean esquivar);
    public boolean getEsquivar();
    public void templatePerform(Player player);

}
