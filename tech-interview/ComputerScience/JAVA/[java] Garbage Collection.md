# ππ’ Garbage Collection

<b>| stop-the-world </b>

	- GCμ μ€ννκΈ° μν΄ JVMμ΄ μ νλ¦¬μΌμ΄μ μ€νμ λ©μΆλ κ²
	- GCλ₯Ό μ€ννλ μ°λ λλ₯Ό μ μΈν λλ¨Έμ§ μ°λ λλ λͺ¨λ μμμ μ€λ¨
	- GC μμμ μλ£ν μ΄νμμΌ μ€λ¨νλ μμμ λ€μ μμ
	- μ΄λ€ GC μκ³ λ¦¬μ¦μ μ¬μ©νλλΌλ stop-the-worldλ λ°μ
	- λκ°μ κ²½μ° GC νλμ΄λ μ΄ stop-the-world μκ°μ μ€μ΄λ κ²

<b> | Young & Old Genration </b>

	- Javaμμλ κ°λ°μκ° νλ‘κ·Έλ¨ μ½λλ‘ λ©λͺ¨λ¦¬λ₯Ό λͺμμ μΌλ‘ ν΄μ νμ§ μμ
	- λλΆλΆμ κ°μ²΄λ κΈλ°© μ κ·Ό λΆκ°λ₯ μν(unreachable)κ° λ¨
	- μ€λλ κ°μ²΄μμ μ μ κ°μ²΄λ‘μ μ°Έμ‘°λ μμ£Ό μ κ² μ‘΄μ¬
	- μ΄λ¬ν μ μ κ° 'weak generational hypothesis'
	- μ΄ μ μ μ μ₯μ μ μ΅λν μ΄λ¦¬κΈ° μν΄μ HotSpot VMμμλ ν¬κ² 2κ°λ‘
	  λ¬Όλ¦¬μ  κ³΅κ°μ λλμλ€. λλ‘ λλ κ³΅κ°μ΄ Young μμ­κ³Ό Old μμ­

	| Young μμ­(Yong Generation μμ­)

	μλ‘­κ² μμ±ν κ°μ²΄μ λλΆλΆμ΄ μ¬κΈ°μ μμΉνλ€. λλΆλΆμ κ°μ²΄κ° κΈλ°© μ κ·Ό λΆκ°λ₯ μνκ° λκΈ° λλ¬Έμ λ§€μ° λ§μ κ°μ²΄κ° Young μμ­μ μμ±λμλ€κ° μ¬λΌμ§λ€. μ΄ μμ­μμ κ°μ²΄κ° μ¬λΌμ§λ Minor GCκ° λ°μνλ€κ³  λ§νλ€.

	| Old μμ­(Old Generation μμ­) 

	μ κ·Ό λΆκ°λ₯ μνλ‘ λμ§ μμ Young μμ­μμ μ΄μλ¨μ κ°μ²΄κ° μ¬κΈ°λ‘ λ³΅μ¬λλ€. λλΆλΆ Young μμ­λ³΄λ€ ν¬κ² ν λΉνλ©°, ν¬κΈ°κ° ν° λ§νΌ Young μμ­λ³΄λ€ GCλ μ κ² λ°μνλ€. μ΄ μμ­μμ κ°μ²΄κ° μ¬λΌμ§ λ Major GC(νΉμ Full GC)κ° λ°μνλ€κ³  λ§νλ€.

<br>

<b> <h2> μμ­λ³ λ°μ΄ν° νλ¦ </h2> </b>

<br>

<center> 

![GC1](./GC1.png)

[κ·Έλ¦Ό 1 GC μμ­ λ° λ°μ΄ν° νλ¦λ]

</center>

<br>

μ κ·Έλ¦Όμ Permanent Generation μμ­(μ΄ν Perm μμ­)μ Method AreaλΌκ³ λ νλ€. κ°μ²΄λ μ΅λ₯(intern)λ λ¬Έμμ΄ μ λ³΄λ₯Ό μ μ₯νλ κ³³μ΄λ©°, Old μμ­μμ μ΄μλ¨μ κ°μ²΄κ° μμν λ¨μ μλ κ³³μ μ λ μλλ€. μ΄ μμ­μμ GCκ° λ°μν  μλ μλλ°, μ¬κΈ°μ GCκ° λ°μν΄λ Major GCμ νμμ ν¬ν¨λλ€.

<br>

κ·Έλ λ€λ©΄ "Old μμ­μ μλ κ°μ²΄κ° Young μμ­μ κ°μ²΄λ₯Ό μ°Έμ‘°νλ κ²½μ°κ° μμ λμλ μ΄λ»κ² μ²λ¦¬λ κΉ?"λΌκ³  κΆκΈν΄ νλ λΆλ λλ¬ μμ κ²μ΄λ€. μ΄λ¬ν κ²½μ°λ₯Ό μ²λ¦¬νκΈ° μν΄μ Old μμ­μλ 512λ°μ΄νΈμ λ©μ΄λ¦¬(chunk)λ‘ λμ΄ μλ μΉ΄λ νμ΄λΈ(card table)μ΄ μ‘΄μ¬νλ€.

<br>

μΉ΄λ νμ΄λΈμλ Old μμ­μ μλ κ°μ²΄κ° Young μμ­μ κ°μ²΄λ₯Ό μ°Έμ‘°ν  λλ§λ€ μ λ³΄κ° νμλλ€. Young μμ­μ GCλ₯Ό μ€νν  λμλ Old μμ­μ μλ λͺ¨λ  κ°μ²΄μ μ°Έμ‘°λ₯Ό νμΈνμ§ μκ³ , μ΄ μΉ΄λ νμ΄λΈλ§ λ€μ Έμ GC λμμΈμ§ μλ³νλ€.

<br>

<center> 

![GC2](./GC2.png)

[κ·Έλ¦Ό 2 μΉ΄λ νμ΄λΈ κ΅¬μ‘°]

</center>

<br>

μΉ΄λ νμ΄λΈμ write barrierλ₯Ό μ¬μ©νμ¬ κ΄λ¦¬νλ€. write barrierλ Minor GCλ₯Ό λΉ λ₯΄κ² ν  μ μλλ‘ νλ μ₯μΉμ΄λ€. write barrirerλλ¬Έμ μ½κ°μ μ€λ²ν€λλ λ°μνμ§λ§ μ λ°μ μΈ GC μκ°μ μ€μ΄λ€κ² λλ€.

<br>

<b> <h2> Young μμ­μ κ΅¬μ± </h2> </b> <br>

GCλ₯Ό μ΄ν΄νκΈ° μν΄μ κ°μ²΄κ° μ μΌ λ¨Όμ  μμ±λλ Young μμ­λΆν° μμλ³΄μ. Young μμ­μ 3κ°μ μμ­μΌλ‘ λλλ€.

Eden μμ­, Survivor μμ­(2κ°). Survivor μμ­μ΄ 2κ°μ΄κΈ° λλ¬Έμ μ΄ 3κ°μ μμ­μΌλ‘ λλλ κ²μ΄λ€. κ° μμ­μ μ²λ¦¬ μ μ°¨λ₯Ό μμμ λ°λΌμ κΈ°μ νλ©΄ λ€μκ³Ό κ°λ€.

μλ‘ μμ±ν λλΆλΆμ κ°μ²΄λ Eden μμ­μ μμΉνλ€.
Eden μμ­μμ GCκ° ν λ² λ°μν ν μ΄μλ¨μ κ°μ²΄λ Survivor μμ­ μ€ νλλ‘ μ΄λλλ€.
Eden μμ­μμ GCκ° λ°μνλ©΄ μ΄λ―Έ μ΄μλ¨μ κ°μ²΄κ° μ‘΄μ¬νλ Survivor μμ­μΌλ‘ κ°μ²΄κ° κ³μ μμΈλ€. <br> 

νλμ Survivor μμ­μ΄ κ°λ μ°¨κ² λλ©΄ κ·Έ μ€μμ μ΄μλ¨μ κ°μ²΄λ₯Ό λ€λ₯Έ Survivor μμ­μΌλ‘ μ΄λνλ€. κ·Έλ¦¬κ³  κ°λ μ°¬ Survivor μμ­μ μλ¬΄ λ°μ΄ν°λ μλ μνλ‘ λλ€.
μ΄ κ³Όμ μ λ°λ³΅νλ€κ° κ³μν΄μ μ΄μλ¨μ μλ κ°μ²΄λ Old μμ­μΌλ‘ μ΄λνκ² λλ€. <br> 

μ΄ μ μ°¨λ₯Ό νμΈν΄ λ³΄λ©΄ μκ² μ§λ§ Survivor μμ­ μ€ νλλ λ°λμ λΉμ΄ μλ μνλ‘ λ¨μ μμ΄μΌ νλ€. λ§μ½ λ Survivor μμ­μ λͺ¨λ λ°μ΄ν°κ° μ‘΄μ¬νκ±°λ, λ μμ­ λͺ¨λ μ¬μ©λμ΄ 0μ΄λΌλ©΄ μ¬λ¬λΆμ μμ€νμ μ μμ μΈ μν©μ΄ μλλΌκ³  μκ°νλ©΄ λλ€. <br>

μ΄λ κ² Minor GCλ₯Ό ν΅ν΄μ Old μμ­κΉμ§ λ°μ΄ν°κ° μμΈ κ²μ κ°λ¨ν λνλ΄λ©΄ λ€μκ³Ό κ°λ€.

<br>

<center> 

![GC3](./GC3.png)

[κ·Έλ¦Ό 3 GC μ κ³Ό νμ λΉκ΅]

</center>

<br>

μ°Έκ³ λ‘, HotSpot VMμμλ λ³΄λ€ λΉ λ₯Έ λ©λͺ¨λ¦¬ ν λΉμ μν΄μ λ κ°μ§ κΈ°μ μ μ¬μ©νλ€. νλλ bump-the-pointerλΌλ κΈ°μ μ΄λ©°, λ€λ₯Έ νλλ TLABs(Thread-Local Allocation Buffers)λΌλ κΈ°μ μ΄λ€.

<br>

bump-the-pointerλ Eden μμ­μ ν λΉλ λ§μ§λ§ κ°μ²΄λ₯Ό μΆμ νλ€. λ§μ§λ§ κ°μ²΄λ Eden μμ­μ λ§¨ μ(top)μ μλ€. κ·Έλ¦¬κ³  κ·Έ λ€μμ μμ±λλ κ°μ²΄κ° μμΌλ©΄, ν΄λΉ κ°μ²΄μ ν¬κΈ°κ° Eden μμ­μ λ£κΈ° μ λΉνμ§λ§ νμΈνλ€. λ§μ½ ν΄λΉ κ°μ²΄μ ν¬κΈ°κ° μ λΉνλ€κ³  νμ λλ©΄ Eden μμ­μ λ£κ² λκ³ , μλ‘ μμ±λ κ°μ²΄κ° λ§¨ μμ μκ² λλ€. λ°λΌμ, μλ‘μ΄ κ°μ²΄λ₯Ό μμ±ν  λ λ§μ§λ§μ μΆκ°λ κ°μ²΄λ§ μ κ²νλ©΄ λλ―λ‘ λ§€μ° λΉ λ₯΄κ² λ©λͺ¨λ¦¬ ν λΉμ΄ μ΄λ£¨μ΄μ§λ€.

<br>

κ·Έλ¬λ λ©ν° μ€λ λ νκ²½μ κ³ λ €νλ©΄ μ΄μΌκΈ°κ° λ¬λΌμ§λ€. Thread-SafeνκΈ° μν΄μ λ§μ½ μ¬λ¬ μ€λ λμμ μ¬μ©νλ κ°μ²΄λ₯Ό Eden μμ­μ μ μ₯νλ €λ©΄ λ½(lock)μ΄ λ°μν  μ λ°μ μκ³ , lock-contention λλ¬Έμ μ±λ₯μ λ§€μ° λ¨μ΄μ§κ² λ  κ²μ΄λ€. HotSpot VMμμ μ΄λ₯Ό ν΄κ²°ν κ²μ΄ TLABsμ΄λ€.

<br>

κ°κ°μ μ€λ λκ° κ°κ°μ λͺ«μ ν΄λΉνλ Eden μμ­μ μμ λ©μ΄λ¦¬λ₯Ό κ°μ§ μ μλλ‘ νλ κ²μ΄λ€. κ° μ°λ λμλ μκΈ°κ° κ°κ³  μλ TLABμλ§ μ κ·Όν  μ μκΈ° λλ¬Έμ, bump-the-pointerλΌλ κΈ°μ μ μ¬μ©νλλΌλ μλ¬΄λ° λ½μ΄ μμ΄ λ©λͺ¨λ¦¬ ν λΉμ΄ κ°λ₯νλ€.

<br>

κ°λ¨νκ² Young μμ­μ λν GCμ λν΄μ μμλ³΄μλ€. μμμ μ΄μΌκΈ°ν λ κ°μ§ κΈ°μ (bump-the-pointer, TLABs)μ λ°λμ κΈ°μ΅νκ³  μμ νμλ μλ€. λͺ°λΌλ μ κ³ λ μμ°¨κ³  κ²½μ°° μΆλ μνλ€. κ·Έλ¬λ Eden μμ­μ μ΅μ΄λ‘ κ°μ²΄κ° λ§λ€μ΄μ§κ³ , Survivor μμ­μ ν΅ν΄μ Old μμ­μΌλ‘ μ€λ μ΄μλ¨μ κ°μ²΄κ° μ΄λνλ€λ μ¬μ€μ κΌ­ κΈ°μ΅νκΈ° λ°λλ€.

<br>

<b> <h2> Old μμ­μ λν GC </h2> </b>

Old μμ­μ κΈ°λ³Έμ μΌλ‘ λ°μ΄ν°κ° κ°λ μ°¨λ©΄ GCλ₯Ό μ€ννλ€. GC λ°©μμ λ°λΌμ μ²λ¦¬ μ μ°¨κ° λ¬λΌμ§λ―λ‘, μ΄λ€ GC λ°©μμ΄ μλμ§ μ΄ν΄λ³΄λ©΄ μ΄ν΄κ° μ¬μΈ κ²μ΄λ€. GC λ°©μμ JDK 7μ κΈ°μ€μΌλ‘ 5κ°μ§ λ°©μμ΄ μλ€.

<br>

<b> 

- Serial GC
- Parallel GC
- Parallel Old GC(Parallel Compacting GC)
- Concurrent Mark & Sweep GC(μ΄ν CMS)

</b> 

<br>


<b> | G1(Garbage First) GC </b> 

	μ΄ μ€μμ μ΄μ μλ²μμ μ λ μ¬μ©νλ©΄ μ λλ λ°©μμ΄ Serial GCλ€. Serial GCλ λ°μ€ν¬ν±μ CPU μ½μ΄κ° νλλ§ μμ λ μ¬μ©νκΈ° μν΄μ λ§λ  λ°©μμ΄λ€. Serial GCλ₯Ό μ¬μ©νλ©΄ μ νλ¦¬μΌμ΄μμ μ±λ₯μ΄ λ§μ΄ λ¨μ΄μ§λ€.

<b> | Serial GC (-XX:+UseSerialGC) </b> 

	Young μμ­μμμ GCλ μ μ μμ μ€λͺν λ°©μμ μ¬μ©νλ€. Old μμ­μ GCλ mark-sweep-compactμ΄λΌλ μκ³ λ¦¬μ¦μ μ¬μ©νλ€. μ΄ μκ³ λ¦¬μ¦μ μ²« λ¨κ³λ Old μμ­μ μ΄μ μλ κ°μ²΄λ₯Ό μλ³(Mark)νλ κ²μ΄λ€. κ·Έ λ€μμλ ν(heap)μ μ λΆλΆλΆν° νμΈνμ¬ μ΄μ μλ κ²λ§ λ¨κΈ΄λ€(Sweep). λ§μ§λ§ λ¨κ³μμλ κ° κ°μ²΄λ€μ΄ μ°μλκ² μμ΄λλ‘ νμ κ°μ₯ μ λΆλΆλΆν° μ±μμ κ°μ²΄κ° μ‘΄μ¬νλ λΆλΆκ³Ό κ°μ²΄κ° μλ λΆλΆμΌλ‘ λλλ€(Compaction).
	
	Serial GCλ μ μ λ©λͺ¨λ¦¬μ CPU μ½μ΄ κ°μκ° μ μ λ μ ν©ν λ°©μμ΄λ€.

<b> | Parallel GC (-XX:+UseParallelGC) </b> 

	Parallel GCλ Serial GCμ κΈ°λ³Έμ μΈ μκ³ λ¦¬μ¦μ κ°μ§λ€. κ·Έλ¬λ Serial GCλ GCλ₯Ό μ²λ¦¬νλ μ€λ λκ° νλμΈ κ²μ λΉν΄, Parallel GCλ GCλ₯Ό μ²λ¦¬νλ μ°λ λκ° μ¬λ¬ κ°μ΄λ€. κ·Έλ κΈ° λλ¬Έμ Serial GCλ³΄λ€ λΉ λ₯Έκ² κ°μ²΄λ₯Ό μ²λ¦¬ν  μ μλ€. Parallel GCλ λ©λͺ¨λ¦¬κ° μΆ©λΆνκ³  μ½μ΄μ κ°μκ° λ§μ λ μ λ¦¬νλ€. Parallel GCλ Throughput GCλΌκ³ λ λΆλ₯Έλ€.
	
λ€μ κ·Έλ¦Όμ Serial GCμ Parallel GCμ μ€λ λλ₯Ό λΉκ΅ν κ·Έλ¦Όμ΄λ€.

<center> 

![GC4](./GC4.png)

[κ·Έλ¦Ό 4 Serial GCμ Parallel GCμ μ°¨μ΄]

</center>

<br>

<b> | Parallel Old GC(-XX:+UseParallelOldGC) </b> 

	Parallel Old GCλ JDK 5 update 6λΆν° μ κ³΅ν GC λ°©μμ΄λ€. μμ μ€λͺν Parallel GCμ λΉκ΅νμ¬ Old μμ­μ GC μκ³ λ¦¬μ¦λ§ λ€λ₯΄λ€. μ΄ λ°©μμ Mark-Summary-Compaction λ¨κ³λ₯Ό κ±°μΉλ€. Summary λ¨κ³λ μμ GCλ₯Ό μνν μμ­μ λν΄μ λ³λλ‘ μ΄μ μλ κ°μ²΄λ₯Ό μλ³νλ€λ μ μμ Mark-Sweep-Compaction μκ³ λ¦¬μ¦μ Sweep λ¨κ³μ λ€λ₯΄λ©°, μ½κ° λ λ³΅μ‘ν λ¨κ³λ₯Ό κ±°μΉλ€.

<br>

<b> | CMS GC (-XX:+UseConcMarkSweepGC) </b> 

	λ€μ κ·Έλ¦Όμ Serial GCμ CMS GCμ μ μ°¨λ₯Ό λΉκ΅ν κ·Έλ¦Όμ΄λ€. κ·Έλ¦Όμμ λ³΄λ―μ΄ CMS GCλ μ§κΈκΉμ§ μ€λͺν GC λ°©μλ³΄λ€ λ λ³΅μ‘νλ€.

<center> 

![GC5](./GC5.png)

[κ·Έλ¦Ό 5 Serial GCμ CMS GC]

</center>

<br>

	μ΄κΈ° Initial Mark λ¨κ³μμλ ν΄λμ€ λ‘λμμ κ°μ₯ κ°κΉμ΄ κ°μ²΄ μ€ μ΄μ μλ κ°μ²΄λ§ μ°Ύλ κ²μΌλ‘ λλΈλ€. λ°λΌμ, λ©μΆλ μκ°μ λ§€μ° μ§§λ€. κ·Έλ¦¬κ³  Concurrent Mark λ¨κ³μμλ λ°©κΈ μ΄μμλ€κ³  νμΈν κ°μ²΄μμ μ°Έμ‘°νκ³  μλ κ°μ²΄λ€μ λ°λΌκ°λ©΄μ νμΈνλ€. μ΄ λ¨κ³μ νΉμ§μ λ€λ₯Έ μ€λ λκ° μ€ν μ€μΈ μνμμ λμμ μ§νλλ€λ κ²μ΄λ€.

	κ·Έ λ€μ Remark λ¨κ³μμλ Concurrent Mark λ¨κ³μμ μλ‘ μΆκ°λκ±°λ μ°Έμ‘°κ° λκΈ΄ κ°μ²΄λ₯Ό νμΈνλ€. λ§μ§λ§μΌλ‘ Concurrent Sweep λ¨κ³μμλ μ°λ κΈ°λ₯Ό μ λ¦¬νλ μμμ μ€ννλ€. μ΄ μμλ λ€λ₯Έ μ€λ λκ° μ€νλκ³  μλ μν©μμ μ§ννλ€.

	μ΄λ¬ν λ¨κ³λ‘ μ§νλλ GC λ°©μμ΄κΈ° λλ¬Έμ stop-the-world μκ°μ΄ λ§€μ° μ§§λ€. λͺ¨λ  μ νλ¦¬μΌμ΄μμ μλ΅ μλκ° λ§€μ° μ€μν  λ CMS GCλ₯Ό μ¬μ©νλ©°, Low Latency GCλΌκ³ λ λΆλ₯Έλ€.

	κ·Έλ°λ° CMS GCλ stop-the-world μκ°μ΄ μ§§λ€λ μ₯μ μ λ°ν΄ λ€μκ³Ό κ°μ λ¨μ μ΄ μ‘΄μ¬νλ€.

	λ€λ₯Έ GC λ°©μλ³΄λ€ λ©λͺ¨λ¦¬μ CPUλ₯Ό λ λ§μ΄ μ¬μ©νλ€.
	Compaction λ¨κ³κ° κΈ°λ³Έμ μΌλ‘ μ κ³΅λμ§ μλλ€.
	λ°λΌμ, CMS GCλ₯Ό μ¬μ©ν  λμλ μ μ€ν κ²ν ν νμ μ¬μ©ν΄μΌ νλ€. κ·Έλ¦¬κ³  μ‘°κ°λ λ©λͺ¨λ¦¬κ° λ§μ Compaction μμμ μ€ννλ©΄ λ€λ₯Έ GC λ°©μμ stop-the-world μκ°λ³΄λ€ stop-the-world μκ°μ΄ λ κΈΈκΈ° λλ¬Έμ Compaction μμμ΄ μΌλ§λ μμ£Ό, μ€λ«λμ μνλλμ§ νμΈν΄μΌ νλ€.

<br>

<b> | G1 GC </b> 

	λ§μ§λ§μΌλ‘ G1(Garbage First) GCμ λν΄μ μμλ³΄μ. G1 GCλ₯Ό μ΄ν΄νλ €λ©΄ μ§κΈκΉμ§μ Young μμ­κ³Ό Old μμ­μ λν΄μλ μλ κ²μ΄ μ’λ€.
	λ€μ κ·Έλ¦Όμμ λ³΄λ€μνΌ, G1 GCλ λ°λνμ κ° μμ­μ κ°μ²΄λ₯Ό ν λΉνκ³  GCλ₯Ό μ€ννλ€. κ·Έλ¬λ€κ°, ν΄λΉ μμ­μ΄ κ½ μ°¨λ©΄ λ€λ₯Έ μμ­μμ κ°μ²΄λ₯Ό ν λΉνκ³  GCλ₯Ό μ€ννλ€. μ¦, μ§κΈκΉμ§ μ€λͺν Youngμ μΈκ°μ§ μμ­μμ λ°μ΄ν°κ° Old μμ­μΌλ‘ μ΄λνλ λ¨κ³κ° μ¬λΌμ§ GC λ°©μμ΄λΌκ³  μ΄ν΄νλ©΄ λλ€. G1 GCλ μ₯κΈ°μ μΌλ‘ λ§λ λ§κ³  νλ λ§μ CMS GCλ₯Ό λμ²΄νκΈ° μν΄μ λ§λ€μ΄ μ‘λ€.

<center> 

![GC6](./GC6.png)

[κ·Έλ¦Ό 6 G1 GCμ λ μ΄μμ]

</center>


	G1 GCμ κ°μ₯ ν° μ₯μ μ μ±λ₯μ΄λ€. μ§κΈκΉμ§ μ€λͺν μ΄λ€ GC λ°©μλ³΄λ€λ λΉ λ₯΄λ€. νμ§λ§, JDK 6μμλ G1 GCλ₯Ό early accessλΌκ³  λΆλ₯΄λ©° κ·Έλ₯ μνμΌμ μ¬μ©ν  μλ§ μλλ‘ νλ€. κ·Έλ¦¬κ³  JDK 7μμ μ μμΌλ‘ G1 GCλ₯Ό ν¬ν¨νμ¬ μ κ³΅νλ€.

	κ·Έλ¬λ JDK 7μ μ€μλΉμ€μμ μ¬μ©νλ €λ©΄ λ§μ κ²μ¦ κΈ°κ°(1λμ νμνλ€λ μκ°μ΄λ€)μ κ±°μ³μΌ ν  κ²μΌλ‘ λ³΄μ΄κΈ° λλ¬Έμ, G1 GCλ₯Ό λΉμ₯ μ¬μ©νκ³  μΆμ΄λ λ κΈ°λ€λ¦¬λ κ²μ΄ μ’λ€λ κ²μ΄ κ°μΈμ μΈ μκ°μ΄λ€. JDK 6μμ G1 GCλ₯Ό μ μ©νλ€κ° JVM Crashκ° λ°μνλ€λ λ§λ λͺ λ² λ€μκΈ°μ λλμ± μμ νλ  λκΉμ§ κΈ°λ€λ¦¬λ κ²μ΄ μ’κ² λ€.

<br>

