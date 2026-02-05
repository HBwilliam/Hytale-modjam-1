package com.basil.machine.configs;

import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;

public class PurityEntry {
    public static final BuilderCodec<PurityEntry> CODEC = BuilderCodec.builder(PurityEntry.class, PurityEntry::new)
            .append(new KeyedCodec<>("Purity", Codec.STRING), PurityEntry::setPurity, PurityEntry::getPurity).add()
            .append(new KeyedCodec<>("Speed", Codec.DOUBLE), PurityEntry::setSpeed, PurityEntry::getSpeed).add()
            .append(new KeyedCodec<>("Amount", Codec.INTEGER), PurityEntry::setAmount, PurityEntry::getAmount).add()
            .build();

    private String purity;
    private double speed;
    private int amount;

    public PurityEntry() {}

    public PurityEntry(String purity, double speed, int amount) {
        this.purity = purity;
        this.speed = speed;
        this.amount = amount;
    }

    public String getPurity() { return purity; }
    public void setPurity(String purity) { this.purity = purity; }
    public double getSpeed() { return speed; }
    public void setSpeed(double speed) { this.speed = speed; }
    public int getAmount() { return amount; }
    public void setAmount(int amount) { this.amount = amount; }

}

