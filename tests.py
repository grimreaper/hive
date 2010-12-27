import hive
def testGetAdjacentPieces():
	b = hive.Board()
	if b.getAdjacentPieces(0,1).sort() != [(1,0),(2,1)].sort():
		print ("Test for 0,1 failed")
	if b.getAdjacentPieces(2,1).sort() != [(1,0),(2,0),(2,2),(3,2)].sort():
		print("Test for 2,1 failed")

testGetAdjacentPieces()
