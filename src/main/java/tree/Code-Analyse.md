Vorteile:
Generische Implementation
Modellierung ist strukturiert
tree Package auch ausserhalb von CatCafe einsetzbar

Nachteile:
CompareTo nur bei einem Wert führt zu doppelten/vergessenen Knoten im Baum,
siehe: Mortizia, Gwenapurr.
Rekursive Implementation von addData kann bei zu großen Bäumen
zu Leistungsverlust führen.

Schleifen:
Iterable Interface implementieren (Tree<T> extends Iterable<T>)
iterator Methode implementieren in Node und Empty

Streams:
spliterator() Methode implementieren
stream() Methode implementieren aus StreamSupport der aus einem
vorhandenen spliterator einen Stream erzeugt.

TreeIterator:
Basiert auf einen Stack.
Konstruktor erzeugt Stack.
pushAllLeftNodes pusht Nodes in den Stack solange Node nicht leer.
hasNext überprüft ob Node vorhanden im Stack.
next gibt nächstes Element wieder.




