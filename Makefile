JAVA_SRC = competition/Competition.java \
		   competition/League.java \
		   competition/Tournament.java \
		   competition/Master.java \
		   competition/StrategyBestOne.java \
		   competition/StrategyFirstAndTwoSecondAndTwoLast.java \
		   competition/StrategyTwoBestAndTwoThird.java \
		   competition/TournamentException.java \
		   competitor/Competitor.java \
		   match/Match.java \
		   match/MatchRandom.java \
		   match/MockMatchRandom.java \
		   util/MapUtil.java \
		   MainTournament.java \
		   MainMaster.java \
		   MainLeague.java

JAVA_TEST =	test/competition/CompetitionTest.java \
			test/competition/TournamentTest.java \
			test/competition/LeagueTest.java \
			test/competition/MasterTest.java \
			test/competition/MasterStrategy1Test.java \
			test/competition/MasterStrategy2Test.java \
			test/competition/MasterStrategy3Test.java \
			test/match/MockMatchRandomTest.java
CLASSES = $(JAVA_SRC:.java=.class)

# -------- Commandes Clean code --------
clean:
	rm -rf classes doc manifest.mf jar out

# -------- Commandes génération de la documentation --------
doc:
	cd src; \
	javadoc $(JAVA_SRC) -d ../doc; \
	cd ..


# -------- Commandes génération de l'archive du projet --------
league.jar:
	make cls
	mkdir -p jar
	jar cvfe jar/league.jar MainLeague -C classes/ .


tournament.jar:
	make cls
	mkdir -p jar
	jar cvfe jar/tournament.jar MainTournament -C classes/ .

master.jar:
	make cls
	mkdir -p jar
	jar cvfe jar/master.jar MainMaster -C classes/ .


# -------- Commandes génération de l'archive du projet --------
league:
	java -jar jar/league.jar


tournament:
	java -jar jar/tournament.jar

master:
	java -jar jar/master.jar


# -------- Commandes Compilation src.java--------
cls: 
	cd src ;\
	javac $(JAVA_SRC) -d ../classes ;\
	cd ..


# -------- Commandes Compilation test.java--------
cls_test: 
	javac -classpath test4poo.jar $(JAVA_TEST) -d classes/

# -------- Commandes Execution Test--------

testmatchrandom:
	java -jar test4poo.jar match.MockMatchRandomTest
testleague:
	java -jar test4poo.jar competition.LeagueTest
testtournament:
	java -jar test4poo.jar competition.TournamentTest
teststrategy1:
	java -jar test4poo.jar competition.MasterStrategy1Test
teststrategy2:
	java -jar test4poo.jar competition.MasterStrategy2Test
teststrategy3:
	java -jar test4poo.jar competition.MasterStrategy3Test





