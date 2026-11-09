# TP Java : Les Génériques

## Présentation du TP

Ce TP a pour objectif de découvrir et de maîtriser les génériques (*Generics*) en Java à travers deux exercices pratiques.

Les génériques permettent de créer des classes et des méthodes réutilisables qui peuvent travailler avec différents types de données tout en garantissant la sécurité de typage.

Ce TP comporte deux exercices :

- **Exercice 1 : Triplet homogène** – Utilisation d'un seul paramètre générique `T` pour stocker trois éléments du même type.
- **Exercice 2 : Triplet hétérogène** – Utilisation de trois paramètres génériques `A`, `B` et `C` pour stocker trois éléments de types différents.

---

## Objectifs pédagogiques

À la fin de ce TP, on doit être capable de :

- Comprendre le fonctionnement des génériques en Java.
- Déclarer une classe générique avec un seul paramètre de type.
- Déclarer une classe générique avec plusieurs paramètres de types.
- Utiliser les constructeurs pour initialiser des objets génériques.
- Utiliser les méthodes getters pour accéder aux attributs.
- Comprendre la sécurité de typage (*Type Safety*).
- Manipuler des objets de différents types sans effectuer de conversions explicites (*casts*).
- Transformer les éléments d'un objet générique en une liste.

---

# Exercice 1 : Triplet homogène

## 1. Objectif

Créer une classe générique `Triplet<T>` permettant de stocker trois objets du même type.

La classe doit permettre :
- De stocker trois éléments.
- D'accéder aux éléments avec des getters.
- D'afficher les trois éléments.

## 2. Structure de la classe

La classe utilise un seul paramètre générique :

`Triplet<T>`

Le paramètre `T` représente le type commun aux trois éléments.

### Attributs

- `premier` : premier élément.
- `second` : deuxième élément.
- `troisieme` : troisième élément.

Les trois attributs sont déclarés avec `private final`, ce qui signifie qu'ils sont privés et ne peuvent pas être réaffectés après leur initialisation.

## 3. Fichier Triplet.java

```java
package ma.projet;

public class Triplet<T> {

    private final T premier;
    private final T second;
    private final T troisieme;

    // Constructeur
    public Triplet(T premier, T second, T troisieme) {
        this.premier = premier;
        this.second = second;
        this.troisieme = troisieme;
    }

    // Getters
    public T getPremier() {
        return premier;
    }

    public T getSecond() {
        return second;
    }

    public T getTroisieme() {
        return troisieme;
    }

    // Méthode d'affichage
    public void affiche() {
        System.out.println("Triplet : [" + premier + ", "
                + second + ", " + troisieme + "]");
    }
}
```

## 4. Fichier TestTriplet.java

Ce programme permet de tester la classe `Triplet<T>` avec deux types différents : `Integer` et `String`.

```java
package ma.projet;

public class TestTriplet {

    public static void main(String[] args) {

        // Triplet d'entiers
        Triplet<Integer> tInt = new Triplet<>(1, 2, 3);
        tInt.affiche();

        // Triplet de chaînes
        Triplet<String> tStr = new Triplet<>("A", "B", "C");
        tStr.affiche();

        // Utilisation des getters
        System.out.println("Premier élément : " + tInt.getPremier());
        System.out.println("Deuxième élément : " + tInt.getSecond());
        System.out.println("Troisième élément : " + tInt.getTroisieme());
    }
}
```

## 5. Résultat attendu

```text
Triplet : [1, 2, 3]
Triplet : [A, B, C]
Premier élément : 1
Deuxième élément : 2
Troisième élément : 3
```

## 6. Explication

La déclaration `Triplet<Integer>` indique que les trois éléments doivent être des entiers.

La déclaration `Triplet<String>` indique que les trois éléments doivent être des chaînes de caractères.

Le compilateur Java vérifie les types et empêche l'insertion d'un élément incompatible.

**Exemple :**

```java
Triplet<Integer> t = new Triplet<>(1, 2, 3);
```

Cette instruction est correcte.

En revanche :

```java
Triplet<Integer> t = new Triplet<>(1, "Bonjour", 3);
```

Cette instruction provoque une erreur de compilation, car `"Bonjour"` est une chaîne et non un entier.

---

# Exercice 2 : Triplet hétérogène

## 1. Objectif

Créer une classe générique `TripletH<A, B, C>` permettant de stocker trois éléments de types potentiellement différents.

Contrairement à l'exercice précédent, chaque élément peut avoir son propre type.

La classe doit permettre :
- De stocker trois éléments de types différents.
- D'accéder aux éléments avec des getters.
- D'afficher les trois éléments.
- De transformer les éléments en une liste avec la méthode `toList()`.

## 2. Structure de la classe

La classe utilise trois paramètres génériques :

`TripletH<A, B, C>`

- `A` représente le type du premier élément.
- `B` représente le type du deuxième élément.
- `C` représente le type du troisième élément.

## 3. Fichier TripletH.java

```java
package ma.projet;

import java.util.ArrayList;
import java.util.List;

public class TripletH<A, B, C> {

    private final A premier;
    private final B second;
    private final C troisieme;

    // Constructeur
    public TripletH(A premier, B second, C troisieme) {
        this.premier = premier;
        this.second = second;
        this.troisieme = troisieme;
    }

    // Getters
    public A getPremier() {
        return premier;
    }

    public B getSecond() {
        return second;
    }

    public C getTroisieme() {
        return troisieme;
    }

    // Méthode d'affichage
    public void affiche() {
        System.out.println("TripletH : [" + premier + ", "
                + second + ", " + troisieme + "]");
    }

    // Transformation en liste
    public List<Object> toList() {
        List<Object> liste = new ArrayList<>();

        liste.add(premier);
        liste.add(second);
        liste.add(troisieme);

        return liste;
    }
}
```

## 4. Fichier TestTripletH.java

Ce programme teste la classe avec plusieurs combinaisons de types.

```java
package ma.projet;

public class TestTripletH {

    public static void main(String[] args) {

        // Exemple 1 : Integer, String, Double
        TripletH<Integer, String, Double> th =
                new TripletH<>(42, "Answer", 3.14);

        th.affiche();

        // Exemple 2 : String, Integer, Boolean
        TripletH<String, Integer, Boolean> th2 =
                new TripletH<>("Alice", 30, true);

        th2.affiche();

        // Utilisation des getters
        System.out.println("Premier élément : " + th.getPremier());
        System.out.println("Deuxième élément : " + th.getSecond());
        System.out.println("Troisième élément : " + th.getTroisieme());

        // Utilisation de toList()
        System.out.println("Liste : " + th.toList());
    }
}
```

## 5. Résultat attendu

```text
TripletH : [42, Answer, 3.14]
TripletH : [Alice, 30, true]
Premier élément : 42
Deuxième élément : Answer
Troisième élément : 3.14
Liste : [42, Answer, 3.14]
```

## 6. Explication

Dans l'instruction suivante :

```java
TripletH<Integer, String, Double> th =
        new TripletH<>(42, "Answer", 3.14);
```

On utilise trois types différents :

- `Integer` pour le nombre 42.
- `String` pour le texte "Answer".
- `Double` pour le nombre décimal 3.14.

Chaque getter retourne automatiquement le type correspondant.

### La méthode toList()

La méthode `toList()` permet de regrouper les trois éléments dans une liste de type `Object`.

On utilise :
- `ArrayList` pour créer une liste dynamique.
- `add()` pour ajouter les éléments.
- `return` pour retourner la liste.

---

# Comparaison entre les deux exercices

| Caractéristique | Exercice 1 | Exercice 2 |
|---|---|---|
| Classe | `Triplet<T>` | `TripletH<A,B,C>` |
| Paramètres génériques | 1 | 3 |
| Types des éléments | Identiques | Potentiellement différents |
| Getters | Trois getters de type T | Trois getters de types A, B et C |
| Exemple | `Integer, Integer, Integer` | `Integer, String, Double` |

---

# Structure finale du projet

```text
ProjetGeneriques/
│
└── src/
    └── ma/
        └── projet/
            ├── Triplet.java
            ├── TestTriplet.java
            ├── TripletH.java
            └── TestTripletH.java
│
└── README.md
```

# Notions importantes à retenir

| Notion | Description |
|---|---|
| Génériques | Permettent de créer des classes réutilisables. |
| `<T>` | Paramètre générique unique. |
| `<A,B,C>` | Plusieurs paramètres génériques. |
| `private` | Rend un attribut accessible uniquement dans sa classe. |
| `final` | Empêche la réaffectation d'un attribut après son initialisation. |
| Constructeur | Initialise les attributs de l'objet. |
| Getter | Permet de récupérer la valeur d'un attribut. |
| `ArrayList` | Liste dynamique en Java. |
| `Object` | Type parent de toutes les classes Java. |
| Type Safety | Vérification de la compatibilité des types. |

# Conclusion

Ce TP nous a permis de comprendre les principes fondamentaux des génériques en Java.

Dans le premier exercice, nous avons créé une classe `Triplet<T>` capable de stocker trois éléments du même type.

Dans le deuxième exercice, nous avons développé une classe `TripletH<A,B,C>` permettant de manipuler trois éléments de types différents.

Nous avons également utilisé les constructeurs, les getters, les listes et la méthode `toList()`.

Les génériques permettent donc d'améliorer la réutilisation du code, la sécurité de typage et la flexibilité des programmes Java.

---

**Technologies utilisées :**
- Langage : Java
- IDE : Eclipse
- Package : `ma.projet`
- Concepts : Programmation générique (Generics), classes, constructeurs, getters et collections.
  <img width="960" height="540" alt="image" src="https://github.com/user-attachments/assets/3b87aa3e-256d-4e38-90f0-b7753074ab95" />
<img width="960" height="540" alt="image" src="https://github.com/user-attachments/assets/7600f0cc-fbb0-44f8-8c60-388c8c9f3b67" />
