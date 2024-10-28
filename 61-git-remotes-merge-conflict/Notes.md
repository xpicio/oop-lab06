```
❯ git clone git@github.com:APICe-at-DISI/OOP-git-merge-conflict-test.git oop-61
Clone in 'oop-61' in corso...
remote: Enumerating objects: 12, done.
remote: Counting objects: 100% (4/4), done.
remote: Compressing objects: 100% (3/3), done.
remote: Total 12 (delta 1), reused 1 (delta 1), pack-reused 8 (from 1)
Ricezione degli oggetti: 100% (12/12), fatto.
Risoluzione dei delta: 100% (2/2), fatto.
```

```
❯ git status
Sul branch master
Il tuo branch è aggiornato rispetto a 'origin/master'.

non c'è nulla di cui eseguire il commit, l'albero di lavoro è pulito
```

```
❯ git merge feature
Merge automatico di HelloWorld.java in corso
CONFLITTO (contenuto): conflitto di merge in HelloWorld.java
Merge automatico fallito; risolvi i conflitti ed esegui il commit
Merge branch 'feature'
del risultato.
```

```
❯ git status
Sul branch master
Il tuo branch è aggiornato rispetto a 'origin/master'.

Hai dei percorsi non sottoposti a merge.
  (risolvi i conflitti ed esegui "git commit")
  (usa "git merge --abort" per interrompere il merge)

Percorsi non sottoposti a merge:
  (usa "git add <file>..." per contrassegnare il conflitto come risolto)
	entrambi modificati: HelloWorld.java

nessuna modifica aggiunta al commit (usa "git add" e/o "git commit -a")
```

```
❯ git add HelloWorld.java
```

```
❯ git commit
[master 00d0259] Merge branch 'feature'
```

```
❯ git remote add xpicio-remote git@github.com:xpicio/oop-git-merge-conflict-test.git
```

```
❯ git remote
origin
xpicio-remote
```

```
❯ git push -u xpicio-remote master
Enumerazione degli oggetti in corso: 15, fatto.
Conteggio degli oggetti in corso: 100% (15/15), fatto.
Compressione delta in corso, uso fino a 10 thread
Compressione oggetti in corso: 100% (11/11), fatto.
Scrittura degli oggetti in corso: 100% (15/15), 1.56 KiB | 1.56 MiB/s, fatto.
Total 15 (delta 4), reused 10 (delta 2), pack-reused 0 (from 0)
remote: Resolving deltas: 100% (4/4), done.
To github.com:xpicio/oop-git-merge-conflict-test.git
 * [new branch]      master -> master
branch 'master' set up to track 'xpicio-remote/master'.
```
