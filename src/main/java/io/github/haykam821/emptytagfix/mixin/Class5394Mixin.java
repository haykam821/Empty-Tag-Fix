package io.github.haykam821.emptytagfix.mixin;

import java.util.Collections;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.class_5394;

@Mixin(class_5394.class)
class Class5394Mixin {
	@Shadow
	private static net.minecraft.class_5394<Object> field_25592;

	@Inject(method = "method_29900", at = @At("RETURN"), cancellable = true)
	private static void useUniqueEmptyTag(CallbackInfoReturnable<class_5394<?>> ci) {
		if (ci.getReturnValue() == field_25592) {
			ci.setReturnValue(new class_5394<Object>(Collections.emptySet(), Object.class));
		}
	}
}