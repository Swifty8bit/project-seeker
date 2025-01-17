package ru.homyakin.seeker.locale.spin;

import java.util.Collections;
import java.util.HashMap;
import ru.homyakin.seeker.game.models.Money;
import ru.homyakin.seeker.infrastructure.Icons;
import ru.homyakin.seeker.infrastructure.PersonageMention;
import ru.homyakin.seeker.locale.Language;
import ru.homyakin.seeker.locale.Resources;
import ru.homyakin.seeker.utils.StringNamedTemplate;

public class EverydaySpinLocalization {
    private static final Resources<EverydaySpinResource> resources = new Resources<>();

    public static void add(Language language, EverydaySpinResource resource) {
        resources.add(language, resource);
    }

    public static String notEnoughUsers(Language language, int requiredUsers) {
        return StringNamedTemplate.format(
            resources.getOrDefault(language, EverydaySpinResource::notEnoughUsers),
            Collections.singletonMap("required_users", requiredUsers)
        );
    }

    public static String alreadyChosen(Language language, PersonageMention mention) {
        return StringNamedTemplate.format(
            resources.getOrDefaultRandom(language, EverydaySpinResource::alreadyChosen),
            Collections.singletonMap("mention_personage_badge_with_name", mention.value())
        );
    }

    public static String chosenUser(Language language, PersonageMention mention, Money money) {
        final var params = new HashMap<String, Object>();
        params.put("mention_personage_badge_with_name", mention.value());
        params.put("money_icon", Icons.MONEY);
        params.put("money_count", money.value());
        return StringNamedTemplate.format(
            resources.getOrDefaultRandom(language, EverydaySpinResource::chosenUser),
            params
        );
    }

    public static String noChosenUsers(Language language) {
        return resources.getOrDefault(language, EverydaySpinResource::noChosenUsers);
    }

    public static String topChosenUsers(Language language) {
        return resources.getOrDefault(language, EverydaySpinResource::topChosenUsers);
    }
}
