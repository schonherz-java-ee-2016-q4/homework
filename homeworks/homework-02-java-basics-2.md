## 2. Házi Feladat - Stopped Servers Reporting
### Határidő: November 27, Vasárnap, 20:00

**A feladat a következő**:  
**[Itt](https://github.com/schonherz-java-ee-2016-q4/homework/tree/master/homeworks/02-java-basics/project)** találtok egy projekt vázat.
Amint látjátok van a projektben pár adathordozó osztály (a domain csomag alatt).
A feladat az, hogy írjatok egy konzol alkalmazást, ami a files könyvtár alatt lévő fájlokat beolvasva és feldolgozva valós idejű jelentést ír a konzolra
azokról a szerverekről, amelyek le vannak állítva (`STOPPED` az állapotuk).

A jelentés formátuma legyen a következő:  
[Szerver ID] - [Szerver Név] - [Szerver Típus]  
\----------------------------------------------  
[Adminisztrátor 1 ID] - [Adminisztrátor 1 Név]  
[Adminisztrátor 2 ID] - [Adminisztrátor 2 Név]  
.  
.  
.  
[Adminisztrátor N ID] - [Adminisztrátor N Név]  

A files könyvtár alatt találjátok a két fájlt, ami a jelentés összerakásához szükséges.  
A `sysadmins.txt` Név-ID-AdminisztráltSzerverIDk formátumban rendszeradminisztrátorok információit tartalmazza. Értelemszerűen egy adott sysadmin több szervert is tarthat karban.  
A `servers.txt` pedig ID-Név-Típus-Státusz formátumban szerverek információt tartalmazza.

A feladat **valós-idejű** kitétele azt jelenti, hogy ha futásidőben megváltoztatsz egy fájlt, akkor a változás automatikusan látszik a konzol kimeneten, a jelentésben.
**A jelentés 2 másodpercenként frissüljön.**

**Extra követelmény: a Builder pattern implementálása a `Server` osztályhoz!**

**Tippek és bónuszok**:
- Tartsuk észben a SOLID alapelveket. Kifejezetten, de nem kizáróan gondolok itt a Single Responsibility elvére.
- Tartsuk észben a generikusokat és az interface-ekre alapuló implementációkat.
- Ha nem tévedek nagyot, a meglévő osztályokba/enumokba nem kell belenyúlnotok, a Main-en kívül természetesen.
- Ha valaki megoldja, hogy a régi konzol kimenet minden frissítéskor törlődjön (szóval ne egymás alá kerüljenek a jelentések futásidőben), annak fizetek egy sört.


**Beadás menete**:  
A master branchen csináljon magának mindenki egy könyvtárat a saját nevével. Ebben a könyvtárban hozzon létre a házi sorszámának megfelelően elnevezett könyvtárat.  
Ebbe a könyvtárba dolgozzátok ki a feladatot.
Szóval ha engem Vályogvető Arisztotelésznek hívnának, akkor /valyogveto-arisztotelesz/2/ alá dolgoznék.

Jó munkát, jó szurkolást, bármilyen kérdés, észrevétel van, keressetek bátran Facebookon, faxon, galambpostán!
