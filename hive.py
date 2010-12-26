#!/usr/bin/env python

board = None

class Board:
	#outer list is y, inner lists are x
	_grid = None
	
	def __init__(self):
		self._grid = list(xrange(44))
		for i in self._grid:
			self._grid[i] = list(xrange(44))
	
	def isOpen(x,y):
		if y % 2 == 0:
			if x % 2 == 1:
				return True
			else:
				return False
		elif y % 2 == 0:
			if x % 2 == 0:
				return True
			else:
				return False
	
	def getAdjacentPieces(x,y):
		#if y % 2 == 0:
			 
		#for y in self._grid:
			#for x in y:
		pass


class Piece:
	_player = None
	_top = None
	
	def __init__(self, p, board):
		self._player = p
	def isAllowedToMove():
		pass
	def isValidMove(sx, sy, dx, dy):
		pass
	def isValidInsert(dx, dy):
		pieces = board.getAdjacentPieces(dx, dy)
		hasSamePlayer = False
		for piece in pieces:
			if piece._player == self._player:
				hasSamePlayer = True
			else:
				return False
		return hasSamePlayer

class Bee(Piece):
	pass
class Ant(Piece):
	pass
class Beetle(Piece):
	pass
class Grasshopper(Piece):
	pass
class Spider(Piece):
	pass

print ("hello")

b = Board()
