package net.zincdev.engine.amber.util;

import net.zincdev.engine.amber.util.condition.Condition;
import net.zincdev.engine.amber.util.factory.Factory;

public record Identifier(String value) {
    private static final Factory.Void<Identifier> $FactoryRandomIdentifier = () -> new Identifier(StringExt.RandomString(/* 0 */ 48,  /* z */ 122, 20));
    public static Identifier Random(Condition.Mono<Identifier> condition) {
        Identifier random = $FactoryRandomIdentifier.Create();
        while(condition.Apply(random)) {
            random = $FactoryRandomIdentifier.Create();
        }
        return random;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Identifier other) return this.value == other.value;
        else return false;
    }
}
